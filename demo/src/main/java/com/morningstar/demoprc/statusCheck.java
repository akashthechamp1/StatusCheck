package com.morningstar.demoprc;
import java.io.IOException;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import com.rabbitmq.client.Channel;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.CoreAdminParams.CoreAdminAction;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class statusCheck {
	public CloudSolrClient solrConnectionHandle;
	private static final Logger log = Logger.getLogger(statusCheck.class);
	public  void quickStatus(String name[]) throws SolrServerException, IOException {
		
		String urlString="http://rsmdrdevap8022:8983/solr";
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();
	    QueryResponse resp = solr.query(name[0], new SolrQuery("*:*"));
		if(resp.getStatus()!=0)
		{
			log.error(name[0]+" Core is Down");
		}
		  
		/*	solrConnectionHandle.setDefaultCollection(name[0]);
		System.out.println(solrConnectionHandle.ping());*/
		
	}
	
	
	
	public static void main(String[] args) throws SolrServerException, IOException {
          try{	
	              statusCheck obj = new statusCheck();
	
		//	solrConnectionHandle.setDefaultCollection("mdrinputcache");
		/*	solrConnectionHandle.setZkConnectTimeout(20000);
			System.out.println(solrConnectionHandle.ping());*/

	String urlString="http://rsmdrdevap8022:8983/solr/";
	SolrClient solrserver = new HttpSolrClient.Builder(urlString).build();			
						      
						   	  CoreAdminRequest request = new CoreAdminRequest();
						   	  request.setAction(CoreAdminAction.STATUS);
						   	  CoreAdminResponse cores = request.process(solrserver);

						   	  for (int i = 0; i < cores.getCoreStatus().size(); i++) {
						   		     System.out.println( cores.getStatus());
						    	     obj.quickStatus(cores.getCoreStatus().getName(i).toString().split("_"));
						    	  }
						}
						catch(Exception e)
						{
						log.error(e);
						}


        String confFile = "spring-context.xml";
      	ConfigurableApplicationContext context= new ClassPathXmlApplicationContext(confFile);
      	RMQConfig m = (RMQConfig) context.getBean("RBConfig");
      	//System.out.println(m.toString());
      	//System.out.println(m.getHost());
      	context.close();
      	
      	ConnectionFactory factory = new ConnectionFactory();
      	factory.setUsername(m.getUserName());
      	factory.setPassword(m.getPassword());
      	factory.setVirtualHost(m.getVirtualHost());
      	factory.setHost(m.getHost());
      	factory.setPort(m.getPort());

	/*ConnectionFactory factory = new ConnectionFactory();
	factory.setUsername("admin");
	factory.setPassword("admin123");
	factory.setVirtualHost("/");
	factory.setHost("rsmdrdevap8002");
	factory.setPort(5672);*/
	
	try{
    Connection connection = factory.newConnection();
   // Channel channel = connection.createChannel();
    log.info("RabbitMQ is up");
	}
	catch(Exception e)
	{
	log.error("RabbitMQ id down");
	}
    



}
				
	}
		
		
		
		
		
		
		
		
			
/*CloudSolrServer server = new CloudSolrServer("rsmdrdevap8017:8080,rsmdrdevap8018:8080,rsmdrdevap8019:8080/mdrsearch ");
server.setDefaultCollection("dwminputcache");
SolrPingResponse resp = server.ping();
System.out.print(resp.getStatus());*/
/*Collection<Slice> slices = reader.getClusterState().getSlices("dwminputcache");
Iterator<Slice> iter = slices.iterator();

while (iter.hasNext()) {
    Slice slice = iter.next();
    for(Replica replica:slice.getReplicas()) {

        System.out.println("replica state for " + replica.getStr("core") + " : "+ replica.getStr( "state" ));

        System.out.println(slice.getName());
        System.out.println(slice.getState());
    }
	}
		// TODO Auto-generated method stub

*/	

	
