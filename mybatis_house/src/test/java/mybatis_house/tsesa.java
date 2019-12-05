package mybatis_house;

import org.junit.Test;

import com.accp.mybatis_house.dao.IHouseDao;
import com.accp.mybatis_house.pojo.Img;
import com.accp.mybatis_house.util.SqlSessionUtil;

public class tsesa {
	@Test
	public void Testdd() {
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		Img i=dao.loadImg("2029038714");
		System.out.println(i.getAddress());
	}
}
