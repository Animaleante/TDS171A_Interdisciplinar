@extends('layouts.site.master')

@section('content')
<main class="main" role="main">
    <div class="wrap clearfix">
        <div class="row">
            <section class="content center full-width">
                <div class="modal container">
                    <h3>Login</h3>

                    {{-- <form class="form-horizontal" method="POST" action="{{ route('login') }}"> --}}
                    <form class="form-horizontal" method="POST" action="{{ route('site.login.store') }}">
                        {{ csrf_field() }}
                        {{-- <div class="f-row">
                            <input type="email" name="email" placeholder="Your e-mail" />
                        </div> --}}
                        <div class="f-row">
                            <input type="text" name="nome_usuario" placeholder="Login" />
                        </div>
                        <div class="f-row">
                            <input type="password" name="password" placeholder="Senha" />
                        </div>
                        
                        <div class="f-row">
                            <input type="checkbox" name="remember" />
                            <label>Lembrar de mim</label>
                        </div>
                        
                        <div class="f-row bwrap">
                            <input type="submit" value="login" />
                        </div>
                    </form>

                    <p><a href="{{ route('site.password.request') }}">Esqueceu sua senha?</a></p>
                    <p>Ainda não tem uma conta? <a href="{{ route('site.register.index') }}">Se registre!</a></p>
                </div>
            </section>
        </div>
    </div>
</main>
@endsection
