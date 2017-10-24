@extends('layouts.site.master')

@section('content')
<main class="main" role="main">
    <div class="wrap clearfix">
        <div class="row">
            <section class="content center full-width">
                <div class="modal container">
                <h3>Reset Password</h3>

                    @if ($errors->any())
                        <div class="alert alert-danger">
                            <ul>
                                @foreach ($errors->all() as $error)
                                    <li>{{ $error }}</li>
                                @endforeach
                            </ul>
                        </div>
                    @endif

                    <form class="form-horizontal" method="POST" action="{{ route('password.request') }}">
                        {{ csrf_field() }}

                        <input type="hidden" name="token" value="{{ $token }}">

                        <div class="f-row{{ $errors->has('email') ? ' has-error' : '' }}">
                            <input id="email" type="text" name="email" placeholder="E-mail" value="{{ $email or old('email') }}" required autofocus/>
                        </div>

                        <div class="f-row{{ $errors->has('password') ? ' has-error' : '' }}">
                            <input id="password" type="password" name="password" placeholder="Senha" required/>
                        </div>

                        <div class="f-row{{ $errors->has('password_confirmation') ? ' has-error' : '' }}">
                            <input id="password-confirm" type="password" name="password_confirmation" placeholder="Confirme a Senha" required/>
                        </div>
                        
                        <div class="f-row bwrap">
                            <input type="submit" value="reset password" />
                        </div>
                    </form>

                </div>
            </section>
        </div>
    </div>
</main>
@endsection
