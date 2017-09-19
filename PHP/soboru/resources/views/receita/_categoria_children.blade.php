@foreach($children as $categoria)
    @if($categoria->children()->count())
        <optgroup label="{{ $categoria->nome_categoria }}">
            @include('receita/_categoria_children', ['children' => $categoria->children])
        </optgroup>
    @else
        <option value="{{ $categoria->id }}">{{ $categoria->nome_categoria }}</option>
    @endif
@endforeach