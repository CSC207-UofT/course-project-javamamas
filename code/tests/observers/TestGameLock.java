package tests.observers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.backend.observers.GameLock;

public class TestGameLock {
	
	GameLock lock;
	
	@BeforeEach public void before() {
		
		lock = new GameLock();
		lock.lock(5);
		
	}
	
	@Test public void testLocked() {
		
		assertEquals(true, lock.isValidId());
		
	}
	
	@Test public void testUnlocked() {
		
		lock.unlock(5);
		assertEquals(false, lock.isValidId());
		
	}
	
}
