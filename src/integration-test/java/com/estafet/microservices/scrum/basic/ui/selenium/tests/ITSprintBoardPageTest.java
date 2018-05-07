package com.estafet.microservices.scrum.basic.ui.selenium.tests;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.microservices.scrum.basic.ui.selenium.pages.SprintBoardPage;

public class ITSprintBoardPageTest {

	SprintBoardPage sprintBoardPage;
	
	@Before
	public void before() {
		sprintBoardPage = new SprintBoardPage("2","1");
	}

	@After
	public void after() {
		sprintBoardPage.close();
	}

	@Test
	public void testViewToDoTasks() {
		assertThat(sprintBoardPage.todoTasks().size(), is(1));
		assertThat(sprintBoardPage.todoTasks().get(0).name(), is("this is a task"));
	}
	
	@Test
	public void testViewInProgressTasks() {
		assertThat(sprintBoardPage.inProgressTasks().size(), is(2));
		assertThat(sprintBoardPage.inProgressTasks().get(0).name(), is("hghghg"));
		assertEquals(sprintBoardPage.inProgressTasks().get(0).hours(), "10 Hours");
		assertThat(sprintBoardPage.inProgressTasks().get(1).name(), is("qwwqwqwaa"));
		assertThat(sprintBoardPage.inProgressTasks().get(1).hours(), is("3 Hours"));
	}
	
	@Test
	public void testClickInProgressUpdateHours() {
		assertTrue(sprintBoardPage.inProgressTasks().get(0).updateHours().isLoaded("2", "2", "5"));
	}
	
	@Test
	public void testViewCompletedTasks() {
		assertThat(sprintBoardPage.completedTasks().size(), is(1));
		assertThat(sprintBoardPage.completedTasks().get(0).name(), is("this is a task"));
	}
	
	@Test
	public void testName() {
		assertThat(sprintBoardPage.getName(), is("Sprint #2"));
	}
	
	@Test
	public void testClickProjectsBreadCrumb() {
		assertTrue(sprintBoardPage.projectsBreadCrumb().isLoaded());
	}
	
	@Test
	public void testClickProjectBreadCrumb() {
		assertTrue(sprintBoardPage.projectBreadCrumb().isLoaded("2"));
	}
	
	@Test
	public void testClickSprintBreadCrumb() {
		assertTrue(sprintBoardPage.sprintBreadCrumb().isLoaded("2", "1"));
	}
	
}
