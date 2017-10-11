{{-- @extends('layouts.site.master')

@section('content')
<main class="main" role="main">
    <div class="wrap clearfix">
        <div class="row">
            <section class="content center full-width">
                <div class="modal container">
                    <h3>Login</h3>

                    <form class="form-horizontal" method="POST" action="{{ route('login') }}">
                        {{ csrf_field() }}
                        <div class="f-row">
                            <input type="text" name="login" placeholder="Your username" />
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
 --}}
 <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>{{ config('app.name', 'Laravel') }} - Admin</title>

        <link rel="shortcut icon" href="images/favicon.ico" />

        <link rel="stylesheet" href="{{ asset('css/admin/bootstrap.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/font-awesome.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/ionicons.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/AdminLTE.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/skin-red.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/blue.css') }}">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="../../index2.html"><b>Soboru</b></a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Faça login para iniciar a sessão</p>

                @if ($errors->any())
                    <div class="alert alert-danger">
                        <ul>
                            @foreach ($errors->all() as $error)
                                <li>{{ $error }}</li>
                            @endforeach
                        </ul>
                    </div>
                @endif

                <!-- <form action="/admin" method="post"> -->
                <form action="{{ route('admin.login') }}" method="post">
                    {{ csrf_field() }}

                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="Nome de Usuário" name="login">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Senha" name="password">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> Lembrar de mim
                                </label>
                            </div>
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Login</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>

                <!-- <div class="social-auth-links text-center">
                    <p>- OR -</p>
                    <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
                    Facebook</a>
                    <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
                    Google+</a>
                </div> -->
                <!-- /.social-auth-links -->

                <a href="#">Esqueci minha senha</a><br>
                <!-- <a href="register.html" class="text-center">Register a new membership</a> -->

            </div>
            <!-- /.login-box-body -->
        </div>
        <!-- /.login-box -->

        <script src="{{ asset('js/admin/jquery.min.js') }}"></script>
        <script src="{{ asset('js/admin/bootstrap.min.js') }}"></script>
        <script src="{{ asset('js/admin/icheck.min.js') }}"></script>

        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>
