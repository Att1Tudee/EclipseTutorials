
public class Main {

	public static void main(String[] args) {
		Pen p = new Pen();
		System.out.println(p.color);
		System.out.println(p.point);
		System.out.println(p.type);

		System.out.println(p.clicked);
		
		p.click();
		System.out.println(p.clicked);
		
		Headphones Yamaha = new Headphones();
		System.out.println(Yamaha.color);
		System.out.println(Yamaha.volume);
		Yamaha.volumeUp();
		Yamaha.volumeUp();
		Yamaha.volumeUp();
		System.out.println(Yamaha.volume);
		Yamaha.powerOn();
		System.out.println(Yamaha.power);

	}

}
