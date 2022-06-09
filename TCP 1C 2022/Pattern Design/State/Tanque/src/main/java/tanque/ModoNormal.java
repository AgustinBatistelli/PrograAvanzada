package tanque;

public class ModoNormal extends ModoTanque {

	@Override
	public void mover() {
		System.out.println("me muevo");

	}

	@Override
	public void atacar() {
		System.out.println("10 de danio");

	}

	@Override
	public ModoTanque cambiarModo() {
		return new ModoAsedio();
	}

}
