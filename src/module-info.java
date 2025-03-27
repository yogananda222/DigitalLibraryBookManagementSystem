/**
 * 
 */
/**
 * 
 */
module DigitalLibraryBookManagementSystem {
	requires org.junit.jupiter.api;
	requires junit;
    requires java.base; // Required by default


    exports services;  // Export the main service package
    opens test to junit; // Allows JUnit to access test classes via reflection
}