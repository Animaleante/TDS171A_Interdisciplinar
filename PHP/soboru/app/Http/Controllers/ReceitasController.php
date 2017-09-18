<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Receita;
use App\Models\Categoria;
use App\Models\Ingrediente;
use App\Models\MedidasIngrediente;

class ReceitasController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth')->except(['index', 'show']);
    }

    public function index() {
    	return view('receita.index');
    }

    public function create() {
    	$categorias = Categoria::all();
        $ingredientes = Ingrediente::all();
    	$medidas = MedidasIngrediente::all();
    	return view('receita.create', compact('categorias', 'ingredientes', 'medidas'));
    }

    public function store() {
    	// echo auth()->id();
    	// dd(request()->all());

    	$this->validate(request(), [
            'nome_receita' => 'required|string|max:255',
            'categoria_id' => 'required|not_in:0',
            'porcao' => 'required',
            'tempo_preparo' => 'required',
            'modo_preparo' => 'required',
            'img_path' => 'required',
        ]);

        /*auth()->user()->publish(
        	new Receita(request(['nome_receita', 'categoria_id', 'porcao', 'tempo_preparo', 'modo_preparo', 'img_path']))
        );*/

        /*
            $postCategories = [];
            foreach ($categories as $category) {
                if (!is_numeric($category)) {
                    $postCategories[] = Category::create([
                        'name' => $category,
                        'slug' => str_slug($category)
                    ])->id;
                } else {
                    $postCategories[] = $category;
                }
            }

            $post->categories()->attach($postCategories);
         */

        $receita = Receita::create(request([

        ]));

        return redirect('/');
    }

    public function show() {
    	return view('receita.show');
    }

    public function edit($receitaId) {
    	return view('receita.edit');
    }

    public function update(Receita $receita) {

    }

    public function delete($receitaId) {

    }

    public function destroy(Receita $receita) {

    }
}
