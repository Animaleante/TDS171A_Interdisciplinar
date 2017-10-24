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

                            <form method="POST" action="{{ route('admin.user.edit')}}">
                                {{ csrf_field() }}

                                <div class="box-body">
                                    @include('admin.user._form')
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