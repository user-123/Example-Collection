package javaInheritance;

public sealed class Main_Sealed_Permits permits Kid01, Kid02, Kid03 {//Java限定繼承(sealed, permits)(限定只能由某些class繼承，也算是一種阻止繼承)

	public Main_Sealed_Permits() {}

	public static void main(String[] args) {

	}

}
