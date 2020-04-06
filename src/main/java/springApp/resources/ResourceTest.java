/*
 * Spring’s Resource interface is meant to be a more capable interface 
 * for abstracting access to low-level resources.
 */

package springApp.resources;


import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.util.ResourceUtils;

public class ResourceTest
{
	private static String path = "springApp/resources/employees.dat";

	// if we want to lazily load our resource, we can use ResourceLoader:
	@Autowired
	ResourceLoader resourceLoader;

	// We can also inject a Resource with @Value:
	@Value("classpath:springApp/resources/sample.txt")
	Resource resourceFile;
	
	@Test
	public void usingUrlResource() throws IOException
	{
		URL url = getClass().getResource("sample.txt");
		Resource resource1 = new UrlResource(url);

		if (resource1.exists())
		{
			System.out.println(resource1.getURL().getPath());
		}
		assertEquals(false, resource1.isOpen());

		// ==========================//
		Resource resource2 = new UrlResource("https://spring.io");
		if (resource2.exists())
		{
			System.out.println(resource2.getURL().getPath());
		}
		assertEquals(false, resource2.isOpen());

	}

	@Test
	public void usingClasspathResource() throws IOException
	{
		Resource resource = new ClassPathResource(path, this.getClass().getClassLoader());
		
		File file = resource.getFile();
		String employees = new String(Files.readAllBytes(file.toPath()));
		System.out.println("==>usingClasspathResource content:" + employees);
		assertEquals("Jason,Peter,Bob", employees);
	}

	
	
	@Test
	public void usingFileSystemResource() throws IOException
	{
		URL url = getClass().getResource("employees.dat");
		Resource resource = new FileSystemResource(url.getFile());
		  
		File file = resource.getFile();
		String employees = new String(Files.readAllBytes(file.toPath()));
		System.out.println("==>usingFileSystemResource content:" + employees);
		assertEquals("Jason,Peter,Bob", employees);
	}
	
	@Test
    public  void usingInputStreamResource() 
	{
        ByteArrayInputStream bis = new ByteArrayInputStream("==>usingInputStreamResource".getBytes());
        Resource resource = new InputStreamResource(bis);
        if(resource.exists()) 
        {
            dumpStream(resource);
        }
        assertEquals(true, resource.isOpen());
    }
	
	
	@Test
    public void usingByteArrayResource() 
	{
        Resource resource = new ByteArrayResource("==>usingByteArrayResource".getBytes());
        if(resource.exists()) 
        {
            dumpStream(resource);
        }
        assertEquals(false, resource.isOpen());
    }
	
	@Test
	public void usingSpringResourceUtils() throws IOException
	{
		File file = ResourceUtils.getFile("classpath:" + path);
		
		String employees = new String(Files.readAllBytes(file.toPath()));
		System.out.println("==>usingSpringResourceUtils :" + employees);
		assertEquals("Jason,Peter,Bob", employees);
	}
	
	
	public Resource usingResourceLoader()
	{
		return resourceLoader.getResource("classpath:" + path);
	}

	

	/*
	 * Read its contents by calling getFile
	 * @throws IOException
	 */
	@Test
	public void testReadResourceAsFile() throws IOException
	{
		File file = new ClassPathResource(path).getFile();
		String employees = new String(Files.readAllBytes(file.toPath()));
		System.out.println("==>testReadResourceAsFile content:" + employees);
		assertEquals("Jason,Peter,Bob", employees);
	}

	/**
	 * Reading as an InputStream
	 * @throws IOException
	 */
	@Test
	public void testReadResourceAsStream() throws IOException
	{
		InputStream resource = new ClassPathResource(path).getInputStream();
		try
		{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(resource));

			String employees = reader.lines().collect(Collectors.joining("\n"));
			System.out.println("==>testReadResourceAsStream content:" + employees);
			assertEquals("Jason,Peter,Bob", employees);
			
		} catch (Exception exp)
		{
			exp.printStackTrace();

		}
	}

	

	private void dumpStream(Resource resource)
	{
		InputStream is = null;
		try
		{
			// 1. Get file resource
			is = resource.getInputStream();
			// 2. Read the file
			byte[] descBytes = new byte[is.available()];
			is.read(descBytes);
			System.out.println(new String(descBytes));
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				// 3. close resouce
				is.close();
			} catch (IOException e)
			{

			}
		}
	}

	public ResourceLoader getResourceLoader()
	{
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		this.resourceLoader = resourceLoader;
	}

	public Resource getResourceFile()
	{
		return resourceFile;
	}

	public void setResourceFile(Resource resourceFile)
	{
		this.resourceFile = resourceFile;
	}

}
