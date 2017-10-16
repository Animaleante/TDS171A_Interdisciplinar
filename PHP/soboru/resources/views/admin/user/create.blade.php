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
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Usuários</a></li>
                <li class="active">Criar</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-6 center-block" style="float: none;">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <form method="POST" action="{{ route('admin.user.create')}}">
                                {{ csrf_field() }}

                                <div class="box-body">
                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome completo">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="login">Login</label>
                                        <input type="text" class="form-control" id="login" name="login" placeholder="Login">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="password">Senha</label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Senha">
                                    </div>

                                    <div class="form-group">
                                        <label for="password_confirmation">Senha</label>
                                        <input type="password" class="form-control" id="password_confirmation" name="password_confirmation" placeholder="Confirme a Senha">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="email">E-mail</label>
                                        <input type="email" class="form-control" id="email" name="email" placeholder="E-mail">
                                    </div>
                                    
                                    {{-- Data de Nascimento --}}
                                    <div class="form-group" style="height: 59px;">
                                        <label for="nasc">Data de Nascimento</label>
                                        <input type="text" class="form-control pull-right" id="nasc" name="nasc">
                                    </div>

                                    {{-- Select para Role do Usuario --}}
                                    <div class="form-group">
                                        <label for="role_id">Tipo de usuário</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="role_id" id="role_id" value="1" checked>
                                                Usuário
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="role_id" id="role_id" value="2">
                                                Admin
                                            </label>
                                        </div>
                                    </div>

                                    {{-- Sexo --}}
                                    <div class="form-group">
                                        <label for="sexo_id">Sexo</label>
                                        <select class="form-control" name="sexo_id">
                                            <option value="1" selected>Feminino</option>
                                            <option value="2">Masculino</option>
                                            <option value="3">Indefinido</option>
                                        </select>
                                    </div>

                                    {{-- Recebe e-mails --}}
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="notificacao_email" id="notificacao_email"> Receber notificações por e-mail
                                        </label>
                                    </div>
                                </div>

                                <div class="box-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
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