@extends('layouts.site.master')

@section('content')
<main class="main" role="main">
    <div class="wrap clearfix">
        <div class="row">
            <section class="content center full-width">
                <div class="modal container">
                    <h3>Login</h3>

                    <form class="form-horizontal" method="POST" action="{{ route('login') }}">
                        {{ csrf_field() }}
                        {{-- <div class="f-row">
                            <input type="email" name="email" placeholder="Your e-mail" />
                        </div> --}}
                        <div class="f-row">
                            <input type="text" name="nome_usuario" placeholder="Your username" />
                        </div>
                        <div class="f-row">
                            <input type="password" name="password" placeholder="Your password" />
                        </div>
                        
                        <div class="f-row">
                            <input type="checkbox" name="remember" />
                            <label>Remember me next time</label>
                        </div>
                        
                        <div class="f-row bwrap">
                            <input type="submit" value="login" />
                        </div>
                    </form>

                    <p><a href="#">Forgotten password?</a></p>
                    <p>Dont have an account yet? <a href="{{ route('register') }}">Sign up.</a></p>
                </div>
            </section>
        </div>
    </div>
</main>
@endsection
