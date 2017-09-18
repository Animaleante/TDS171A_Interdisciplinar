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
								</div>
								<div class="f-row">
									<div class="third"><input type="text" placeholder="Serves how many people?" name="porcao" /></div>
									<div class="third">
										<select name="categoria_id">
											<option selected="selected" value="0">Select a category</option>
											<optgroup label="Bla">
												@foreach($categorias as $categoria)
													@if(!$categoria->selecionavel)

													@else
														<option value="{{ $categoria->id }}">{{ $categoria->nome_categoria }}</option>
													@endif
												@endforeach
											</optgroup>
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
									<div class="long"><input type="text" placeholder="Ingredient" name="nome_ingrediente[]" /></div>
									<div class="small"><input type="text" placeholder="SubSession" name="subsessao" /></div>
									<div class="small"><input type="text" placeholder="Quantity" name="qty" /></div>
									<div class="small"><input type="text" placeholder="Medida" name="medida_id" /></div>
									{{-- <div class="third"><select><option selected="selected">Select a category</option></select></div> --}}
									<button class="remove">-</button>
								</div>
								<div class="f-row ingredient" name="ingrediente[]">
									<div class="long"><input type="text" placeholder="Ingredient" name="nome_ingrediente[]" /></div>
									<div class="small"><input type="text" placeholder="SubSession" name="subsessao[]" /></div>
									<div class="small"><input type="text" placeholder="Quantity" name="qty[]" /></div>
									<div class="small"><input type="text" placeholder="Medida" name="medida_id[]" /></div>
									{{-- <div class="third"><select><option selected="selected">Select a category</option></select></div> --}}
									<button class="remove">-</button>
								</div>
								<div class="f-row full">
									<button class="add">Add an ingredient</button>
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