package com.estafet.microservices.scrum.basic.ui.selenium.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;

import static org.hamcrest.core.Is.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import com.estafet.microservices.scrum.basic.ui.selenium.pages.ProjectsPage;
import com.github.tomakehurst.wiremock.WireMockServer;

public class ITProjectsPageTest {

	WireMockServer wireMockServer = new WireMockServer();
	ProjectsPage projectsPage = new ProjectsPage();

	@Before
	public void before() throws Exception {
		wireMockServer.start();
		File file = ResourceUtils.getFile("classpath:project-api-get-projects.json");
		stubFor(get(urlEqualTo("/project-api/projects"))
				.willReturn(aResponse().withBody(new String(Files.readAllBytes(file.toPath())))));
	}

	@After
	public void after() {
		wireMockServer.stop();
		projectsPage.close();
	}

	@Test
	public void testViewProjects() {
		assertThat(projectsPage.getProjects().size(), is(2));
		assertThat(projectsPage.getProjects().get(0), is("My Project #9384"));
		assertThat(projectsPage.getProjects().get(1), is("My Project #1749"));
	}

	@Test
	public void testClickNewProject() {
		assertTrue(projectsPage.newProjectPage().isLoaded());
	}

	@Ignore
	@Test
	public void testClickProject() {
		assertTrue(projectsPage.projectPage("My Project #9384").isLoaded("1"));
	}

}
