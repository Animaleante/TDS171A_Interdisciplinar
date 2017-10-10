@extends('layouts.site.master')

@section('content')
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
                                <label>Sexo:</label>
								<label style="margin-right: 10px;">
									<input type="radio" name="sexo_id" value="1" checked />
									Feminino
								</label>
                                <label>
                                    <input type="radio" name="sexo_id" value="2" />
                                    Masculino
                                </label>
								<label>
									<input type="radio" name="sexo_id" value="3" />
									Indefinido
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
