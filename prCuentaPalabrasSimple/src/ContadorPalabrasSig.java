public class ContadorPalabrasSig extends ContadorPalabras {

	private String[] arrayPalSig;

	public ContadorPalabrasSig(int tam, String[] pal) {
		super(tam);
		arrayPalSig = pal;
	}

	public ContadorPalabrasSig(String[] pal) {
		super();
		arrayPalSig = pal;
	}

	private int esta(String pal) {
		int i = 0;
		PalabraEnTexto p = new PalabraEnTexto(pal);
		while (i < primLibre) {
			if (ArrayPal[i].equals(p)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private boolean estaEnNoSig(String pal) {
		int i = 0;
		while (i < arrayPalSig.length) {
			if (arrayPalSig[i] != null && arrayPalSig[i].equalsIgnoreCase(pal)) {
				return true;
			}
			i++;
		}
		return false;
	}

	public void incluye(String pal) {
		if (!estaEnNoSig(pal)) {
			int pos = esta(pal);
			if (pos == -1) {
				if (primLibre == ArrayPal.length) {
					PalabraEnTexto[] nuevo = new PalabraEnTexto[ArrayPal.length * 2];
					System.arraycopy(ArrayPal, 0, nuevo, 0, ArrayPal.length);
					ArrayPal = nuevo;
				}
				ArrayPal[primLibre] = new PalabraEnTexto(pal);
				primLibre++;
			} else {
				ArrayPal[pos].incrementa();
			}
		}
	}

}

