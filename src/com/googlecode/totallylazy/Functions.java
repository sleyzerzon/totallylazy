package com.googlecode.totallylazy;

import com.googlecode.totallylazy.callables.And;
import com.googlecode.totallylazy.callables.Or;
import com.googlecode.totallylazy.callables.Xor;

import java.util.List;
import java.util.concurrent.Callable;

import static com.googlecode.totallylazy.LazyException.lazyException;
import static com.googlecode.totallylazy.Sequences.sequence;

public class Functions {
    public static <A> Function0<A> function(final Callable<? extends A> callable) {
        return new Function0<A>() {
            @Override
            public A call() throws Exception {
                return callable.call();
            }
        };
    }

    public static <A, B> Function<A, B> function(final Function1<? super A, ? extends B> callable) {
        return new Function<A, B>() {
            @Override
            public B call(A a) throws Exception {
                return callable.call(a);
            }
        };
    }

    public static <A, B, C> Curried2<A, B, C> function(final Function2<? super A, ? super B, ? extends C> callable) {
        return new Curried2<A, B, C>() {
            @Override
            public C call(A a, B b) throws Exception {
                return callable.call(a, b);
            }
        };
    }

    public static <A, B, C, D> Curried3<A, B, C, D> function(final Function3<? super A, ? super B, ? super C, ? extends D> callable) {
        return new Curried3<A, B, C, D>() {
            @Override
            public D call(A a, B b, C c) throws Exception {
                return callable.call(a, b, c);
            }
        };
    }

    public static <A, B, C, D, E> Curried4<A, B, C, D, E> function(final Function4<? super A, ? super B, ? super C, ? super D, ? extends E> callable) {
        return new Curried4<A, B, C, D, E>() {
            @Override
            public E call(A a, B b, C c, D d) throws Exception {
                return callable.call(a, b, c, d);
            }
        };
    }

    public static <A, B, C, D, E, F> Curried5<A, B, C, D, E, F> function(final Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends F> callable) {
        return new Curried5<A, B, C, D, E, F>() {
            @Override
            public F call(A a, B b, C c, D d, E e) throws Exception {
                return callable.call(a, b, c, d, e);
            }
        };
    }

    public static <A> A call(final Callable<? extends A> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            throw lazyException(e);
        }
    }

    public static <A, B> B call(final Function1<? super A, ? extends B> callable, final A a) {
        try {
            return callable.call(a);
        } catch (Exception e) {
            throw lazyException(e);
        }
    }

    public static <A, B, C> C call(final Function2<? super A, ? super B, ? extends C> callable, final A a, final B b) {
        try {
            return callable.call(a, b);
        } catch (Exception e) {
            throw lazyException(e);
        }
    }

    public static <A, B, C, D> D call(final Function3<? super A, ? super B, ? super C, ? extends D> callable, final A a, final B b, final C c) {
        try {
            return callable.call(a, b, c);
        } catch (Exception e) {
            throw lazyException(e);
        }
    }

    public static <A, B, C, D, E> E call(final Function4<? super A, ? super B, ? super C, ? super D, ? extends E> callable, final A a, final B b, final C c, final D d) {
        try {
            return callable.call(a, b, c, d);
        } catch (Exception e) {
            throw lazyException(e);
        }
    }

    public static <A, B, C, D, E, F> F call(final Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends F> callable, final A a, final B b, final C c, final D d, final E e) {
        try {
            return callable.call(a, b, c, d, e);
        } catch (Exception ex) {
            throw lazyException(ex);
        }
    }

    public static <A, B, C> Function<B, C> apply(final Function2<? super A, ? super B, ? extends C> callable, final A value) {
        return new Function<B, C>() {
            @Override
            public C call(B b) throws Exception {
                return callable.call(value, b);
            }
        };
    }

    public static <A, B, C, D> Curried2<B, C, D> apply(final Function3<? super A, ? super B, ? super C, ? extends D> callable, final A value) {
        return new Curried2<B, C, D>() {
            @Override
            public D call(B b, C c) throws Exception {
                return callable.call(value, b, c);
            }
        };
    }

    public static <A, B, C, D, E> Curried3<B, C, D, E> apply(final Function4<? super A, ? super B, ? super C, ? super D, ? extends E> callable, final A value) {
        return new Curried3<B, C, D, E>() {
            @Override
            public E call(B b, C c, D d) throws Exception {
                return callable.call(value, b, c, d);
            }
        };
    }

    public static <A, B, C, D, E, F> Curried4<B, C, D, E, F> apply(final Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends F> callable, final A value) {
        return new Curried4<B, C, D, E, F>() {
            @Override
            public F call(B b, C c, D d, E e) throws Exception {
                return callable.call(value, b, c, d, e);
            }
        };
    }

    public static <A> UnaryFunction<A> identity() {
        return new UnaryFunction<A>() {
            public A call(A self) throws Exception {
                return self;
            }
        };
    }

    public static <A> UnaryFunction<A> identity(Class<A> aClass) {
        return identity();
    }

    public static <A, B> Function<A, B> constant(final B result) {
        return new Function<A, B>() {
            public B call(A ignore) throws Exception {
                return result;
            }
        };
    }

    public static <T> Function0<T> returns(final T t) {
        return new Function0<T>() {
            public final T call() throws Exception {
                return t;
            }
        };
    }

    public static <A, B> Function<A, B> returns1(final B result) {
        return constant(result);
    }

    public static <A, B, C> Curried2<A, B, C> returns2(final C result) {
        return new Curried2<A, B, C>() {
            @Override
            public C call(A ignore, B ignoreMeToo) throws Exception {
                return result;
            }
        };
    }

    public static <A, B, C> Curried2<A, B, C> uncurry2(final Function1<? super A, ? extends Function1<? super B, ? extends C>> callable) {
        return new Curried2<A, B, C>() {
            public final C call(final A a, final B b) throws Exception {
                return callable.call(a).call(b);
            }
        };
    }

    public static <A, B, C, D> Curried3<A, B, C, D> uncurry3(final Function1<? super A, ? extends Function1<? super B, ? extends Function1<? super C, ? extends D>>> callable) {
        return new Curried3<A, B, C, D>() {
            @Override
            public D call(A a, B b, C c) throws Exception {
                return callable.call(a).call(b).call(c);
            }
        };
    }

    public static <A, B, C, D, E> Curried4<A, B, C, D, E> uncurry4(final Function1<? super A, ? extends Function1<? super B, ? extends Function1<? super C, ? extends Function1<? super D, ? extends E>>>> callable) {
        return new Curried4<A, B, C, D, E>() {
            @Override
            public E call(A a, B b, C c, D d) throws Exception {
                return callable.call(a).call(b).call(c).call(d);
            }
        };
    }

    public static <A, B, C, D, E, F> Curried5<A, B, C, D, E, F> uncurry5(final Function1<? super A, ? extends Function1<? super B, ? extends Function1<? super C, ? extends Function1<? super D, ? extends Function1<? super E, ? extends F>>>>> callable) {
        return new Curried5<A, B, C, D, E, F>() {
            @Override
            public F call(A a, B b, C c, D d, E e) throws Exception {
                return callable.call(a).call(b).call(c).call(d).call(e);
            }
        };
    }

    static abstract class IdentityFunction<A,B> extends Function<A,B> implements Identity<B> {}

    public static <A, B, C> Function<Pair<A, B>, C> pair(final Function2<? super A, ? super B, ? extends C> function) {
        if(function instanceof Identity) {
            return new IdentityFunction<Pair<A, B>, C>() {
                @Override
                public C identity() {
                    return Unchecked.<Identity<C>>cast(function).identity();
                }

                @Override
                public C call(Pair<A, B> pair) throws Exception {
                    return function.call(pair.first(), pair.second());
                }
            };
        }
        return new Function<Pair<A, B>, C>() {
            @Override
            public C call(Pair<A, B> pair) throws Exception {
                return function.call(pair.first(), pair.second());
            }
        };
    }

    public static <A, B, C> Curried2<A, B, C> unpair(final Function1<? super Pair<? extends A, ? extends B>, ? extends C> function) {
        return new Curried2<A, B, C>() {
            @Override
            public C call(A a, B b) throws Exception {
                return function.call(Pair.pair(a, b));
            }
        };
    }

    public static <A, B, C, D>Function<Triple<A, B, C>, D> triple(final Function3<? super A, ? super B, ? super C, ? extends D> callable) {
        return new Function<Triple<A, B, C>, D>() {
            @Override
            public D call(Triple<A, B, C> triple) throws Exception {
                return callable.call(triple.first(), triple.second(), triple.third());
            }
        };
    }

    public static <A, B, C, D> Curried3<A, B, C, D> untriple(final Function1<? super Triple<? extends A, ? extends B, ? extends C>, ? extends D> function) {
        return new Curried3<A, B, C, D>() {
            @Override
            public D call(A a, B b, C c) throws Exception {
                return function.call(Triple.triple(a, b, c));
            }
        };
    }

    public static <A, B, C, D, E> Function<Quadruple<A, B, C, D>, E> quadruple(final Function4<? super A, ? super B, ? super C, ? super D, ? extends E> callable) {
        return new Function<Quadruple<A, B, C, D>, E>() {
            @Override
            public E call(Quadruple<A, B, C, D> quadruple) throws Exception {
                return callable.call(quadruple.first(), quadruple.second(), quadruple.third(), quadruple.fourth());
            }
        };
    }

    public static <A, B, C, D, E> Curried4<A, B, C, D, E> unquadruple(final Function1<? super Quadruple<? extends A, ? extends B, ? extends C, ? extends D>, ? extends E> function) {
        return new Curried4<A, B, C, D, E>() {
            @Override
            public E call(A a, B b, C c, D d) throws Exception {
                return function.call(Quadruple.quadruple(a, b, c, d));
            }
        };
    }

    public static <A, B, C, D, E, F> Function<Quintuple<A, B, C, D, E>, F> quintuple(final Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends F> callable) {
        return new Function<Quintuple<A, B, C, D, E>, F>() {
            @Override
            public F call(Quintuple<A, B, C, D, E> quintuple) throws Exception {
                return callable.call(quintuple.first(), quintuple.second(), quintuple.third(), quintuple.fourth(), quintuple.fifth());
            }
        };
    }

    public static <A, B, C, D, E, F> Curried5<A, B, C, D, E, F> unquintuple(final Function1<? super Quintuple<? extends A, ? extends B, ? extends C, ? extends D, ? extends E>, ? extends F> function) {
        return new Curried5<A, B, C, D, E, F>() {
            @Override
            public F call(A a, B b, C c, D d, E e) throws Exception {
                return function.call(Quintuple.quintuple(a, b, c, d, e));
            }
        };
    }

    public static CombinerFunction<Boolean> and = new And();
    public static CombinerFunction<Boolean> or = new Or();
    public static CombinerFunction<Boolean> xor = new Xor();

    public static Function<Pair<Boolean, Boolean>, Boolean> andPair() {
        return new Function<Pair<Boolean, Boolean>, Boolean>() {
            @Override
            public Boolean call(Pair<Boolean, Boolean> pair) throws Exception {
                return pair.first() && pair.second();
            }
        };
    }

    public static Function<Pair<Boolean, Boolean>, Boolean> orPair() {
        return new Function<Pair<Boolean, Boolean>, Boolean>() {
            @Override
            public Boolean call(Pair<Boolean, Boolean> pair) throws Exception {
                return pair.first() || pair.second();
            }
        };
    }

    public static <A, B> Function<A, B> interruptable(final Function1<? super A, ? extends B> function) {
        return new Function<A, B>() {
            @Override
            public B call(A a) throws Exception {
                if (Thread.interrupted()) throw new InterruptedException();
                return function.call(a);
            }
        };
    }

    public static <A> Function0<A> interruptable(final Callable<? extends A> function) {
        return new Function0<A>() {
            @Override
            public A call() throws Exception {
                if (Thread.interrupted()) throw new InterruptedException();
                return function.call();
            }
        };
    }

    public static <A,B> Function<A, Option<B>> option(Predicate<? super A> predicate, Function1<? super A, ? extends B> callable) {
        return function(a -> predicate.matches(a) ? Option.some(callable.call(a)) : Option.none());
    }

    public static <A, B extends A, C> Function<A, Option<C>> instanceOf(Class<B> subCLass, Function1<? super B, ? extends C> callable) {
        return function(a -> subCLass.isInstance(a) ? Option.some(callable.call(subCLass.cast(a))) : Option.none());
    }

    @SafeVarargs
    public static <A,B> Function<A, Option<B>> or(Function1<? super A, ? extends Option<B>>... callables) {
        return function(a -> sequence(callables).flatMap(fun -> fun.call(a)).headOption());
    }

    @SafeVarargs
    public static <A,B> Function<A, List<B>> and(Function1<? super A, ? extends Option<B>>... callables) {
        return function(a -> {
            List<B> result = sequence(callables).flatMap(fun -> fun.call(a)).toList();
            if(result.size() != callables.length) return Lists.list();
            return result;
        });
    }

}
