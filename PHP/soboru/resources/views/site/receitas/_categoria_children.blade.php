@foreach($children as $categoria)
    @if($categoria->children()->count())
        <optgroup label="{{ $categoria->nome }}">
            @include('site.receitas._categoria_children', ['children' => $categoria->children])
        </optgroup>
    @else
        {{-- <option value="{{ $categoria->id }}">{{ $categoria->nome }}</option> --}}
        <option value="{{ $categoria->id }}" {{ (old('categoria_id') == $categoria->id) ? 'selected="selected"' : '' }}>{{ $categoria->nome }}</option>
    @endif
@endforeach