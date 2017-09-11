package com.ebao.spxjunior.spittr.web;

import com.ebao.spxjunior.spittr.Spittle;
import com.ebao.spxjunior.spittr.data.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by dondavid on 17/8/31.
 */
public class SpittleControllerTest {
  @Test
  public void shouldShowRecentSpittles() throws Exception {
    List<Spittle> expectedSpittles = createSpittleList(20);
    SpittleRepository mockRepository = mock(SpittleRepository.class);
    when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
    //这里需要手动去new这个controller,不能通过引入这个controller bean注入到本类中
    //除非,有手动自己实现一个mock的实现类,然后注入到controller中,这里也不需要mock了.
    SpittleController controller = new SpittleController(mockRepository);
    //这里使用internalResourceView,主要是controller返回的view name是spittles,这个和web的请求路径/spittles
    //是一致的,会导致重新dispatch到这个controller的请求,对于spring mvc会陷入循环,当然这个会导致spring报错.
    //所以这里指定唯一的view就是这个jsp.这样避免了歧义.所以写view name尽量避免这种问题.
    MockMvc mockMvc = standaloneSetup(controller)
        .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
    mockMvc.perform(get("/spittles")).andExpect(view().name("spittles"))
        .andExpect(model().attributeExists("spittleList"))
        .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    // hasItems is from hamcrest library
  }

  @Test
  public void shouldShowPagedSpittles() throws Exception {
    List<Spittle> expectedSpittles = createSpittleList(50);
    SpittleRepository mockRepository = mock(SpittleRepository.class);
    //定义这个mockRepositor的行为,请求这个方法时返回这个给定的假数据
    when(mockRepository.findSpittles(238900, 50))
        .thenReturn(expectedSpittles);

    SpittleController controller = new SpittleController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller)
        .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
        .build();

    mockMvc.perform(get("/spittles?max=238900&count=50"))
        .andExpect(view().name("spittles"))
        .andExpect(model().attributeExists("spittleList"))
        .andExpect(model().attribute("spittleList",
            hasItems(expectedSpittles.toArray())));
  }

  @Test
  public void testSpittle() throws Exception {
    Spittle expectedSpittle = new Spittle("Hello", new Date());
    SpittleRepository mockRepository = mock(SpittleRepository.class);
    when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

    SpittleController controller = new SpittleController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller).build();

    mockMvc.perform(get("/spittles/12345"))
        .andExpect(view().name("spittle"))
        .andExpect(model().attributeExists("spittle"))
        .andExpect(model().attribute("spittle", expectedSpittle));
  }

  private List<Spittle> createSpittleList(int count) {
    List<Spittle> spittles = new ArrayList<Spittle>();
    for (int i = 0; i < count; i++) {
      spittles.add(new Spittle("Spittle " + i, new Date()));
    }
    return spittles;
  }

}
