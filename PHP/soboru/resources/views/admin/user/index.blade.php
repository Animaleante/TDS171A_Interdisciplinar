@extends('layouts.admin.master')

@section('styles')
     <link href="{{ asset('css/admin/dataTables.bootstrap.min.css') }}" rel="stylesheet">
@endsection

@section('content')
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Usuários
            </h1>
            <ol class="breadcrumb">
                <li><a href="{{ route('admin.index') }}"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Usuários</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    @if(session()->has('success'))
                        @include('admin.parts._success_message')
                    @endif
                    
                    <div class="box">
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Login</th>
                                        <th>E-mail</th>
                                        <th>Data Cadastro</th>
                                        <th>Tipo</th>
                                        <th width="150">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    @if($results->count())
                                        @foreach($results as $result)
                                            <tr>
                                                <td>{{ $result->id }}</td>
                                                <td>{{ $result->nome }}</td>
                                                <td>{{ $result->login }}</td>
                                                <td>{{ $result->email }}</td>
                                                <td>{{ $result->created_at->format('d/m/Y H:i') }}</td>
                                                <td>{{ $result->role->nome }}</td>

                                                <td>
                                                    <a href="{{route('admin.user.edit', $result->id)}}"
                                                       class="btn btn-default btn-sm">
                                                        <i class="fa fa-edit"></i>
                                                    </a>
                                                    <a class="btn btn-default delete-item btn-sm" data-item-id="{{$result->id}}">
                                                        <i class="fa fa-trash"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        @endforeach
                                    @else
                                        <tr>
                                            <td colspan="8">Nenhum resultado encontrado</td>
                                        </tr>
                                    @endif
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    @include('admin.parts._confirm_delete_modal')
@endsection

@section('scripts')
    <script src="{{ asset('js/admin/jquery.dataTables.min.js') }}"></script>
    <script src="{{ asset('js/admin/dataTables.bootstrap.min.js') }}"></script>
    <script src="{{ asset('js/admin/DeleteItem.js') }}"></script>

    <script type="text/javascript">
        var deleteItem = new DeleteItem('{{route('admin.user.destroy', null)}}');

        $('#example1').DataTable();
        /*$('#example1').DataTable({
            'paging'      : true,
            'lengthChange': false,
            'searching'   : false,
            'ordering'    : true,
            'info'        : true,
            'autoWidth'   : false
        });*/
    </script>
@endsection