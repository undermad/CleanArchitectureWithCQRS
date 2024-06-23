package example.mapper;

public interface Mapper<A, B> {
    A mapToA(B b);
    B mapToB(A a);
}
