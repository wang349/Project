package cn.mldn.factory;

import cn.mldn.service.proxy.ServiceProxy;
import cn.mldn.util.message.MessageUtils;

public class Factory {
	private static final String DAO_BASENAME="cn.mldn.util.message.dao";
	private static final String SERVICE_BASENAME="cn.mldn.util.message.service";
	private static MessageUtils daoMU;
	private static MessageUtils serviceMU;
	static {
		daoMU=new MessageUtils(DAO_BASENAME);
		serviceMU=new MessageUtils(SERVICE_BASENAME);
	}
	private Factory(){};
	@SuppressWarnings("unchecked")
	public static <T> T getServiceInstance(String className){
		System.out.println("xxx");
		try{
			return (T) new ServiceProxy().bind(Class.forName(serviceMU.getValue(className)).newInstance());
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public static <T> T getDAOInstance(String className){
		
		try{
			return (T) Class.forName(daoMU.getValue(className)).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

}
