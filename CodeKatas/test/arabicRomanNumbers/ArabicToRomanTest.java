package arabicRomanNumbers;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ArabicToRomanTest {

	@Test
	public void oneTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(1)).isEqualTo("I");
	}

	@Test
	public void twoTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(2)).isEqualTo("II");
	}

	@Test
	public void treeTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(3)).isEqualTo("III");
	}

	@Test
	public void fourTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(4)).isEqualTo("IV");
	}

	@Test
	public void fiveTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(5)).isEqualTo("V");
	}

	@Test
	public void sixTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(6)).isEqualTo("VI");
	}

	@Test
	public void sevenTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(7)).isEqualTo("VII");
	}

	@Test
	public void eightTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(8)).isEqualTo("VIII");
	}

	@Test
	public void nineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(9)).isEqualTo("IX");
	}

	@Test
	public void tenTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(10)).isEqualTo("X");
	}

	@Test
	public void elevenTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(11)).isEqualTo("XI");
	}

	@Test
	public void forteenTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(14)).isEqualTo("XIV");
	}

	@Test
	public void fifteenTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(15)).isEqualTo("XV");
	}

	@Test
	public void sixteenTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(16)).isEqualTo("XVI");
	}

	@Test
	public void nineteenTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(19)).isEqualTo("XIX");
	}

	@Test
	public void twentyTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(20)).isEqualTo("XX");
	}

	@Test
	public void twentynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(29)).isEqualTo("XXIX");
	}

	@Test
	public void twentyfourTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(24)).isEqualTo("XXIV");
	}

	@Test
	public void thirtynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(39)).isEqualTo("XXXIX");
	}

	@Test
	public void fourtyfourTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(44)).isEqualTo("XLIV");
	}

	@Test
	public void fourtynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(49)).isEqualTo("XLIX");
	}

	@Test
	public void fiftyfourTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(54)).isEqualTo("LIV");
	}

	@Test
	public void fiftynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(59)).isEqualTo("LIX");
	}

	@Test
	public void sixtyfourTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(64)).isEqualTo("LXIV");
	}

	@Test
	public void sixtynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(79)).isEqualTo("LXXIX");
	}

	@Test
	public void seventyfourTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(74)).isEqualTo("LXXIV");
	}

	@Test
	public void seventynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(79)).isEqualTo("LXXIX");
	}

	@Test
	public void eightyTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(80)).isEqualTo("LXXX");
	}

	@Test
	public void eightynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(89)).isEqualTo("LXXXIX");
	}

	@Test
	public void ninetyTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(90)).isEqualTo("XC");
	}

	@Test
	public void ninetynineTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(99)).isEqualTo("XCIX");
	}

	@Test
	public void hundredTest() {
		ArabicRoman resolver = new ArabicRoman();
		assertThat(resolver.getRoman(100)).isEqualTo("C");
	}
}
