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
    	$categorias = Categoria::where('id_super_categoria', '=', null)->get();

        // dd($categorias);

        // $ingredientes = Ingrediente::all();
        $ingredientes = Ingrediente::pluck('nome_ingrediente', 'id');
        // $medidas = MedidasIngrediente::all();
        $medidas = MedidasIngrediente::pluck('nome_medida', 'id');
    	return view('receita.create', compact('categorias', 'ingredientes', 'medidas'));
    }

    public function store() {
    	// echo auth()->id();
    	dd(request()->all());

    	$this->validate(request(), [
            'nome_receita' => 'required|string|max:255',
            'categoria_id' => 'required|not_in:0',
            'porcao' => 'required',
            'tempo_preparo' => 'required',
            'modo_preparo' => 'required',
            'img_path' => 'required',
            // 'nome_ingrediente' => 'required|array|min:3',
            'nome_ingrediente' => 'required|array',
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

        $receita = Receita::create([

        ]);

        // $ar = collect([['nome_ingrediente'=>'Bisteca'],['nome_ingrediente'=>'Mel']]);
        // foreach($ar as $ingrediente) { 
            // App\Models\Ingrediente::create($ingrediente); 
        // }

        //App\Models\Receita::create(['nome_receita'=>'Teste 1', 'categoria_id'=>2, 'user_id'=>1, 'porcao'=>1, 'tempo_preparo'=>2.5, 'modo_preparo'=>'Texto de preparo.', 'img_path'=>'none']);

        // $receita->ingredientes()->attach(2, ['medida_id' => 1, 'subsessao' => 'bla', 'qty' => 1]);
        // Attach several ingredientes
        // $receita->ingredientes()->attach(['3' => ['medida_id' => 1, 'subsessao' => 'bla', 'qty' => 1], '4' => ['medida_id' => 1, 'subsessao' => 'bla', 'qty' => 1]]);

        // Get quantity used in first ingredient
        // $receita->ingredientes->first()->pivot->qty

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
