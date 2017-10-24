@if (session('success'))
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <p>Operação realizada com sucesso!</p>
    </div>
@else
    <div class="alert alert-danger">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <p>Não foi possível realizar a operação.</p>
    </div>
@endif