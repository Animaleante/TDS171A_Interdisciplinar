@extends('layouts.master')

@section('content')
<main class="main" role="main">
	<div class="wrap clearfix">
		<nav class="breadcrumbs">
			<ul>
				<li><a href="index.html" title="Home">Home</a></li>
				<li>Submit a recipe</li>
			</ul>
		</nav>
		
		<div class="row">
			<header class="s-title">
				<h1>Add a new recipe</h1>
			</header>
			
            @if($errors->any())
                <ul>
                    @foreach ($errors->all() as $error)
                        <li>{{ $error }}</li>
                    @endforeach
                </ul>
            @endif

			<section class="content full-width">
				<div class="submit_recipe container">
					<form method="POST" action="/receita/create" enctype="multipart/form-data">
                        {{ csrf_field() }}

						<section>
							<h2>Informações</h2>
							<p>Todos os campos são obrigatórios.</p>
							<div class="f-row">
								<div class="full">
									<input type="text" placeholder="Nome da Receita" name="nome_receita" value="{{ old('nome_receita') }}" />
								</div>
							</div>
							<div class="f-row">
								<div class="third">
									<input type="text" placeholder="Tempo de preparo" name="tempo_preparo" value="{{ old('tempo_preparo') }}" />
								</div>
								<div class="third">
									<input type="text" placeholder="Serve quantas porções?" name="porcao" value="{{ old('porcao') }}" />
								</div>
								<div class="third">
									<select name="categoria_id">
                                        @if(!old('categoria_id'))
											<option selected="selected" value="0" disabled>Selecione uma categoria</option>
										@endif
										@foreach($categorias as $categoria)
											@if($categoria->children()->count())
												<optgroup label="{{ $categoria->nome_categoria }}">
													@include('receita/_categoria_children', ['children' => $categoria->children])
												</optgroup>
											@else
												<option value="{{ $categoria->id }}" {{ (old('categoria_id') == $categoria->id) ? 'selected="selected"' : '' }}>{{ $categoria->nome_categoria }}</option>
											@endif
										@endforeach
									</select>
								</div>
							</div>
						</section>

						<section id="ingredientes">
							<h2>Ingredientes</h2>
							@for ($i = 0; $i < count(old('nome_ingrediente')); $i++)
								<div class="f-row ingredient">
                                    <div class="large">
                                        <input class="ingrediente-input" type="text" placeholder="Ingrediente" name="nome_ingrediente[]" value="{{ old('nome_ingrediente')[$i] }}" />
                                    </div>
                                    <div class="small">
                                        <input type="text" placeholder="SubSession" name="receita_ingrediente[subsessao][]" value="{{ old('receita_ingrediente')['subsessao'][$i] }}" />
                                    </div>
                                    <div class="small">
                                        <input type="text" placeholder="Quantity" name="receita_ingrediente[qty][]" value="{{ old('receita_ingrediente')['qty'][$i] }}" />
                                    </div>
                                    <div class="small">
                                        <select name="receita_ingrediente[medida_id][]">
                                            @if(!array_key_exists('medida_id', old('receita_ingrediente')) || !array_key_exists(''.$i, old('receita_ingrediente')['medida_id']))
                                            	<option selected="selected" disabled value="0">Medida</option>
                                            @endif
                                            
                                            @foreach($medidas as $medidaId=>$medidaNome)
                                            	<option value="{{ $medidaId }}" {{ array_key_exists('medida_id', old('receita_ingrediente')) && (array_key_exists(''.$i, old('receita_ingrediente')['medida_id']) && old('receita_ingrediente')['medida_id'][$i] == $medidaId) ? 'selected="selected"' : '' }}>{{ $medidaNome }}</option>
                                            @endforeach
                                        </select>
                                    </div>
                                    <button class="remove">-</button>
                                </div>
                            @endfor
							<div class="f-row full add-ingredient">
								<button class="add">Adicionar um ingrediente</button>
							</div>
						</section>	
						
						<section>
							<h2>Modo de Preparo</h2>
							<div class="full">
								<div class="f-row instruction">
									<input type="text" name="modo_preparo" value="{{ old('modo_preparo') }}" />
								</div>
							</div>
						</section>
						
						<section>
							<h2>Foto</h2>
							<div class="f-row full">
									<label for="receita-foto" class="btn">Selecionar uma foto</label>
								<input id="receita-foto" type="file" name="img_path" style="display: none;" value="{{ old('img_path') }}" />
							</div>
						</section>

						<div class="f-row full">
							<input type="submit" class="button" id="submitRecipe" value="Publicar essa receita" />
						</div>
					</form>
				</div>
			</section>
		</div>
	</div>
@endsection

@section('scripts')
	<script type="text/javascript">
    	var ingredientes = @json($ingredientes);
    	var medidas = @json($medidas);

		$(document).ready(function() {
			$('button.add').click(function(event) {
				event.stopPropagation();
				event.preventDefault();

				addIngredientRow();
			});

			$('body').on('click', '.ingredient button.remove', function(event) {
				event.stopPropagation();
				event.preventDefault();

				if($('.ingredient').length > 1)
					$(event.target).closest('.ingredient').remove();
			});

			function addIngredientRow() {
				var inputEl = $('<div/>').addClass('f-row ingredient').append(
					$('<div/>').addClass('large').append(
						$('<input/>').addClass('ingrediente-input').attr({'type':'text', 'placeholder':'Ingrediente', 'name':'nome_ingrediente[]'})
					),
					$('<div/>').addClass('small').append(
						$('<input/>').attr({'type':'text', 'placeholder':'Sub-Sessão', 'name':'receita_ingrediente[subsessao][]'})
					),
					$('<div/>').addClass('small').append(
						$('<input/>').attr({'type':'text', 'placeholder':'Quantidade', 'name':'receita_ingrediente[qty][]'})
					),
					$('<div/>').addClass('small').append(
						$('<select/>').attr({'name':'receita_ingrediente[medida_id][]'}).append(
							$('<option/>').attr({'selected':'selected', 'value':0, 'disabled':'disabled'}).text('Medida')
						)
					),
					$('<button/>').addClass('remove').text('-')
				);

				for(var medidaId in medidas) {
					inputEl.find('select').append(
						$('<option/>').attr('value', medidaId).text(medidas[medidaId])
					);
				};

				$('.f-row.add-ingredient').before(
					inputEl
				);

				inputEl.find('.ingrediente-input').typeahead({
					source: Object.keys(ingredientes).map(function(val) {
						return {
							id: val,
							name: ingredientes[val]
						}
					})
				});

				inputEl.find('select').uniform();
			}

			if($('.f-row.ingredient').length === 0)
				addIngredientRow();
		});
	</script>
@endsection