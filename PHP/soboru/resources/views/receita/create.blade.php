@extends('layouts.master')

@section('styles')
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css">
@endsection

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
						<form method="POST" action="/receita/create">
                            {{ csrf_field() }}

							<section>
								<h2>Basics</h2>
								<p>All fields are required.</p>
								<div class="f-row">
									<div class="full"><input type="text" placeholder="Recipe title" name="nome_receita" /></div>
								</div>
								<div class="f-row">
									<div class="third"><input type="text" placeholder="Preparation time" name="tempo_preparo" /></div>
									{{-- <div class="third"><input type="text" placeholder="Cooking time" /></div> --}}
									{{-- <div class="third"><input type="text" placeholder="Difficulty" /></div> --}}
								{{-- </div> --}}
								{{-- <div class="f-row"> --}}
									<div class="third"><input type="text" placeholder="Serves how many people?" name="porcao" /></div>
									<div class="third">
										<select name="categoria_id">
											<option selected="selected" value="0" disabled>Select a category</option>
											{{-- <optgroup label="Bla"> --}}
												{{-- @foreach($categorias as $categoria)
													@if(!$categoria->selecionavel)
														{{-- <optgroup> --}}
													{{-- @else
														<option value="{{ $categoria->id }}">{{ $categoria->nome_categoria }}</option>
													@endif
												@endforeach --}}

												@foreach($categorias as $categoria)
													@if($categoria->children()->count())
														<optgroup label="{{ $categoria->nome_categoria }}">
															@include('receita/_categoria_children', ['children' => $categoria->children])
														</optgroup>
													@else
														<option value="{{ $categoria->id }}">{{ $categoria->nome_categoria }}</option>
													@endif
												@endforeach
											{{-- </optgroup> --}}
										</select>
										{{-- <select name="month">
											<optgroup label="Month:">
												<option value="January">January</option>
											</optgroup>
										</select> --}}
									</div>
								</div>
							</section>
							
							{{-- <section>
								<h2>Description</h2>
								<div class="f-row">
									<div class="full"><textarea placeholder="Recipe description"></textarea></div>
								</div>
							</section> --}}	
							
							<section>
								<h2>Ingredients</h2>
								<div class="f-row ingredient">
									{{-- <div class="long"><input type="text" placeholder="Ingredient" name="nome_ingrediente[]" /></div> --}}
									<div class="large">
										{{-- <select class="ingrediente" multiple="multiple" name="nome_ingrediente[]"> --}}
										<select class="ingrediente" name="nome_ingrediente[]">
											<option value=""></option>
											@foreach($ingredientes as $ingrediente)
												<option value="{{ $ingrediente->id }}">{{ $ingrediente->nome_ingrediente }}</option>
											@endforeach
											{{-- <option selected="selected">Orange</option>
											<option>Banana</option>
											<option selected="selected">Apple</option> --}}
										</select>
									</div>
									<div class="small"><input type="text" placeholder="SubSession" name="receita_ingrediente[subsessao]" /></div>
									<div class="small"><input type="text" placeholder="Quantity" name="receita_ingrediente[qty]" /></div>
									<div class="small"><input type="text" placeholder="Medida" name="receita_ingrediente[medida_id]" /></div>
									{{-- <div class="third"><select><option selected="selected">Select a category</option></select></div> --}}
									<button class="remove">-</button>
								</div>
								<div class="f-row full">
									<button class="add">Add an ingredient</button>
								</div>
								<div class="f-row full">
									<div class="large">
										<select class="test-select">
											<option value=""></option>
											<option>Orange</option>
											<option>Banana</option>
											<option>Apple</option>
										</select>
									</div>
								</div>
							</section>	
							
							<section>
								{{-- <h2>Instructions <span>(enter instructions, each step at a time)</span></h2>
								<div class="f-row instruction">
									<div class="full">
										<input type="text" placeholder="Instructions" name="modo_preparo" />
									</div>
									<button class="remove">-</button>
								</div>
								<div class="f-row full">
									<button class="add">Add a step</button>
								</div> --}}
								<h2>Instructions</h2>
								<div class="full">
									<div class="f-row instruction">
										<input type="text" placeholder="Instructions" name="modo_preparo" />
									</div>
								</div>
							</section>
							
							<section>
								<h2>Photo</h2>
								<div class="f-row full">
									<input type="file" name="img_path" />
								</div>
							</section>	
							
							{{-- <section>
								<h2>Status <span>(would you like to further edit this recipe or are you ready to publish it?)</span></h2>
								<div class="f-row full">
									<input type="radio" id="r1" name="radio"/>
									<label for="r1">I am still working on it</label>
								</div>
								<div class="f-row full">
									<input type="radio" id="r2" name="radio"/>
									<label for="r2">I am ready to publish this recipe</label>
								</div>
							</section> --}}
							
							<div class="f-row full">
								<input type="submit" class="button" id="submitRecipe" value="Publish this recipe" />
							</div>
						</form>
					</div>
				</section>
			</div>
		</div>
	@endsection

	@section('scripts')
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				/*$('.ingrediente').select2({
					placeholder: "Select",
					allowClear: true,
					tags: true
				});*/
				$('.test-select').select2({
					placeholder: "Select",
					allowClear: true,
					tags: true
				});
				// $('.ingrediente').select2();
				// $('.test-select').select2();
			});
		</script>
	@endsection