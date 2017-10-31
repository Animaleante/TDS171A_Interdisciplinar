@extends('layouts.admin.master')

@section('styles')
     <link href="{{ asset('css/admin/bootstrap-datepicker.min.css') }}" rel="stylesheet">
@endsection

@section('content')
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Usuários
            </h1>
            <ol class="breadcrumb">
                <li><a href="{{ route('admin.index') }}"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="{{ route('admin.user.index') }}">Usuários</a></li>
                <li class="active">Editar</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-6 center-block" style="float: none;">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            
                            @if($errors->any())
                                <ul>
                                    @foreach ($errors->all() as $error)
                                        <li>{{ $error }}</li>
                                    @endforeach
                                </ul>
                            @endif

                            <form method="POST" action="{{ route('admin.user.edit', $user)}}">
                                {{ csrf_field() }}

                                <div class="box-body">
                                    {{-- @include('admin.user._form') --}}

                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome completo" value="{{ $user->nome }}">
                                    </div>

                                    <div class="form-group">
                                        <label for="login">Login</label>
                                        <input type="text" class="form-control" id="login" name="login" placeholder="Login" value="{{ $user->login }}">
                                    </div>

                                    <div class="form-group">
                                        <label for="email">E-mail</label>
                                        <input type="email" class="form-control" id="email" name="email" placeholder="E-mail" value="{{ $user->email }}">
                                    </div>

                                    {{-- Data de Nascimento --}}
                                    <div class="form-group" style="height: 59px;">
                                        <label for="nasc">Data de Nascimento</label>
                                        <input type="text" class="form-control pull-right" id="nasc" name="nasc" placeholder="Data de Nascimento" value="{{ $user->nasc->format('d/m/Y') }}">
                                    </div>

                                    {{-- Select para Role do Usuario --}}
                                    <div class="form-group">
                                        <label for="role_id">Tipo de usuário</label>
                                        @foreach($roles as $role)
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="role_id" id="role_id" value="{{ $role->id }}" {{ $user->role_id === $role->id ? "checked" : ""}}>
                                                    {{ $role->nome }}
                                                </label>
                                            </div>
                                        @endforeach
                                    </div>

                                    {{-- Sexo --}}
                                    <div class="form-group">
                                        <label for="sexo_id">Sexo</label>
                                        <select class="form-control" name="sexo_id">
                                            <option value="1" {{ $user->sexo_id === 1 ? "selected" : ""}}>Feminino</option>
                                            <option value="2" {{ $user->sexo_id === 2 ? "selected" : ""}}>Masculino</option>
                                            <option value="3" {{ $user->sexo_id === 3 ? "selected" : ""}}>Indefinido</option>
                                        </select>
                                    </div>

                                    {{-- Recebe e-mails --}}
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="notificacao_email" id="notificacao_email" {{ $user->notificacao_email === 1 ? "checked" : ""}}> Receber notificações por e-mail
                                        </label>
                                    </div>
                                </div>

                                <div class="box-footer">
                                    <button type="submit" class="btn btn-primary">Salvar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
@endsection

@section('scripts')
    <script src="{{ asset('js/admin/bootstrap-datepicker.min.js') }}"></script>

    <script type="text/javascript">
        $("input[name='nasc']").datepicker({
          autoclose: true,
          format: 'dd/mm/yyyy'
        });
    </script>
@endsection