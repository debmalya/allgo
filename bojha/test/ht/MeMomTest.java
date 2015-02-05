package ht;



import org.junit.Assert;
import org.junit.Test;

public class MeMomTest {

	@Test
	public void testSeating() {
		MeMom me = new MeMom();
		MeMom.Bus bus = me.new Bus(new String[]{"3 2","1","2","1 2"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                String seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("1 3", seatingArrangement);
                Assert.assertTrue("1 3".equals(seatingArrangement));
                
                bus = me.new Bus(new String[]{"3 2","1","3","1 2 3"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("1 3 2", seatingArrangement);
                Assert.assertTrue("1 3 2".equals(seatingArrangement));
                
                bus = me.new Bus(new String[]{"3 2","3","3","1 2 3"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("3 1 2", seatingArrangement);
                Assert.assertTrue("3 1 2".equals(seatingArrangement));
                
                bus = me.new Bus(new String[]{"3 2","2","3","1 2 3"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("2 1 3", seatingArrangement);
                Assert.assertTrue("2 1 3".equals(seatingArrangement));
                
                bus = me.new Bus(new String[]{"5 5","5","3","1 3 5"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("5 3 4", seatingArrangement);
                Assert.assertTrue("5 3 4".equals(seatingArrangement));
                
                
                bus = me.new Bus(new String[]{"5 5","1","3","1 3 5"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("1 3 4", seatingArrangement);
                Assert.assertTrue("1 3 4".equals(seatingArrangement));
                
                bus = me.new Bus(new String[]{"5 5","3","3","1 3 5"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("3 5 4", seatingArrangement);
                Assert.assertTrue("3 5 4".equals(seatingArrangement));
                
                bus = me.new Bus(new String[]{"5 5","2","3","1 3 5"});
                bus.process();
		Assert.assertNotNull(bus);
                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
                Assert.assertEquals("2 1 4", seatingArrangement);
                Assert.assertTrue("2 1 4".equals(seatingArrangement));
                
                bus = me.new Bus(new String[]{"20000 5","2","3","1 3 5"});
                bus.process();
		Assert.assertNotNull(bus);
//                bus.printOccupancy();
                seatingArrangement = bus.printFinalSeats();
                System.out.println(seatingArrangement);
//                Assert.assertEquals("2 1 4", seatingArrangement);
//                Assert.assertTrue("2 1 4".equals(seatingArrangement));
	}
	
}
