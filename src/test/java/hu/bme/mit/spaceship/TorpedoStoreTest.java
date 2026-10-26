package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    // Original test provided by the university
    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    // Test 1: Check initial torpedo count
    @Test
    void constructor_InitializesTorpedoCount() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertEquals(10, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    // Test 2: Check an empty torpedo store
    @Test
    void emptyStore_IsEmpty() {
        TorpedoStore store = new TorpedoStore(0, 0.0);

        assertTrue(store.isEmpty());
        assertEquals(0, store.getTorpedoCount());
    }

    // Test 3: Successful firing decreases the count
    @Test
    void fire_Success_DecreasesCount() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        boolean result = store.fire(3);

        assertTrue(result);
        assertEquals(7, store.getTorpedoCount());
    }

    // Test 4: Firing all torpedoes makes the store empty
    @Test
    void fire_AllTorpedoes_StoreBecomesEmpty() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        boolean result = store.fire(5);

        assertTrue(result);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    // Test 5: Firing zero torpedoes is invalid
    @Test
    void fire_ZeroTorpedoes_ThrowsException() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertThrows(
            IllegalArgumentException.class,
            () -> store.fire(0)
        );
    }

    // Test 6: Firing a negative number is invalid
    @Test
    void fire_NegativeTorpedoes_ThrowsException() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertThrows(
            IllegalArgumentException.class,
            () -> store.fire(-1)
        );
    }

    // Test 7: Cannot fire more torpedoes than available
    @Test
    void fire_TooManyTorpedoes_ThrowsException() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertThrows(
            IllegalArgumentException.class,
            () -> store.fire(6)
        );
    }

    // Test 8: Failed firing does not reduce the count
    @Test
    void fire_Failure_DoesNotDecreaseCount() {
        TorpedoStore store = new TorpedoStore(10, 1.0);

        boolean result = store.fire(3);

        assertFalse(result);
        assertEquals(10, store.getTorpedoCount());
    }
}