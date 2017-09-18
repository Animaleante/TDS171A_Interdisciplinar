@extends('layouts.master')

@section('content')
	{{-- <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">Register</div>
                    @if($errors->any())
                        <ul>
                            @foreach ($errors->all() as $error)
                                <li>{{ $error }}</li>
                            @endforeach
                        </ul>
                    @endif
                    <div class="panel-body">
                        <form class="form-horizontal" method="POST" action="{{ route('register') }}">
                            {{ csrf_field() }}

                            <div class="form-group{{ $errors->has('nome_usuario') ? ' has-error' : '' }}">
                                <label for="nome_usuario" class="col-md-4 control-label">Nome</label>

                                <div class="col-md-6">
                                    <input id="nome_usuario" type="text" class="form-control" name="nome_usuario" required autofocus>

                                    @if ($errors->has('nome_usuario'))
                                        <span class="help-block">
                                            <strong>{{ $errors->first('nome_usuario') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group{{ $errors->has('email') ? ' has-error' : '' }}">
                                <label for="email" class="col-md-4 control-label">E-Mail</label>

                                <div class="col-md-6">
                                    <input id="email" type="email" class="form-control" name="email" required>

                                    @if ($errors->has('email'))
                                        <span class="help-block">
                                            <strong>{{ $errors->first('email') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group{{ $errors->has('password') ? ' has-error' : '' }}">
                                <label for="password" class="col-md-4 control-label">Senha</label>

                                <div class="col-md-6">
                                    <input id="password" type="password" class="form-control" name="password" required>

                                    @if ($errors->has('password'))
                                        <span class="help-block">
                                            <strong>{{ $errors->first('password') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password-confirm" class="col-md-4 control-label">Confirme Senha</label>

                                <div class="col-md-6">
                                    <input id="password-confirm" type="password" class="form-control" name="password_confirmation" required>
                                </div>
                            </div>

                            <div class="form-group{{ $errors->has('nasc') ? ' has-error' : '' }}">
                                <label for="nasc" class="col-md-4 control-label">Data de Nascimento</label>

                                <div class="col-md-6">
                                    <input id="nasc" type="date" class="form-control" name="nasc" required>

                                    @if ($errors->has('nasc'))
                                        <span class="help-block">
                                            <strong>{{ $errors->first('nasc') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group{{ $errors->has('sexo_id') ? ' has-error' : '' }}">
                                <label for="sexo_id" class="col-md-4 control-label">Sexo</label>

                                <div class="col-md-6">
                                    <label class="radio-inline">
                                        <input type="radio" name="sexo_id" checked value="0">
                                        Feminino
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sexo_id" value="1">
                                        Masculino
                                    </label>

                                    @foreach ($sexos as $sexo)
                                        <label class="radio-inline">
                                            <input type="radio" name="sexo_id" value="{{ $sexo->id }}">
                                            {{ $sexo->nome_sexo }}
                                        </label>
                                    @endforeach
                                    
                                    @if ($errors->has('sexo_id'))
                                        <span class="help-block">
                                            <strong>{{ $errors->first('sexo_id') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group{{ $errors->has('notificacao_email') ? ' has-error' : '' }}">
                                <label for="notificacao_email" class="col-md-4 control-label">Receber notificações por email</label>

                                <div class="col-md-6">
                                    <input id="notificacao_email" type="checkbox" name="notificacao_email" value="1" style="margin: 0; height: 36px; display: block;">

                                    @if ($errors->has('notificacao_email'))
                                        <span class="help-block">
                                            <strong>{{ $errors->first('notificacao_email') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6 col-md-offset-4">
                                    <button type="submit" class="btn btn-primary">
                                        Register
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div> --}}
	
    <main class="main" role="main">
        <div class="wrap clearfix">
            <div class="row">
                <section class="content center full-width">
                    <div class="modal container">
                        <h3>Register</h3>
						
                        @if($errors->any())
                            <ul>
                                @foreach ($errors->all() as $error)
                                    <li>{{ $error }}</li>
                                @endforeach
                            </ul>
                        @endif

                        <form class="form-horizontal" method="POST" action="{{ route('register') }}">
                            {{ csrf_field() }}
							
							<div class="f-row">
								<input type="text" placeholder="Your name" name="nome_usuario" />
							</div>
							<div class="f-row">
								<input type="email" placeholder="Your email" name="email" />
							</div>
							<div class="f-row">
								<input type="password" placeholder="Your password" name="password" />
							</div>
							<div class="f-row">
								<input type="password" placeholder="Retype password" name="password_confirmation" />
							</div>
							
							<div class="f-row">
								<label>
									Data de Nascimento: 
								</label>
                                <input type="date" placeholder="Retype password" name="nasc" style="border: 1px solid #ddd; color: #666; font-size: 13  font-weight: 400; padding: 9px 10px; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px;"/>
							</div>
							<div class="f-row">
                                <label>
                                    Sexo: 
                                </label>
								<label style="margin-right: 10px;">
									<input type="radio" name="sexo_id" value="1" checked />
									Feminino
								</label>
								<label>
									<input type="radio" name="sexo_id" value="2" />
									Masculino
								</label>
                                {{-- @foreach ($sexos as $sexo)
                                    <label>
                                        <input type="radio" name="sexo_id" value="{{ $sexo->id }}" />
                                        {{ $sexo->nome_sexo }}
                                    </label>
                                @endforeach --}}
							</div>
							<div class="f-row">
								<label>
									Receber notificações por e-mail:
                                    <input type="checkbox" name="notificacao_email" /> 
								</label>
							</div>
							
							<div class="f-row bwrap">
								<input type="submit" value="register" />
							</div>
						</form>
                        <p>Already have an account yet? <a href="login.html">Log in.</a></p>
                    </div>
                </section>
            </div>
        </div>
    </main>
@endsection
