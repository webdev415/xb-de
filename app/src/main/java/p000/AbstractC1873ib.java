package p000;

public abstract class AbstractC1873ib extends Exception {
    public AbstractC1873ib() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1873ib(String str) {
        super(str);
        AbstractC1085Xi.m4796e(str, "Detail message must not be empty");
    }
}
