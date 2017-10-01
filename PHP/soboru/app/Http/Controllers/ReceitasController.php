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
    	$receitas = Receita::all();
    	return view('site.receitas.index', compact('receitas'));
    }

    public function create() {
    	$categorias = Categoria::where('id_super_categoria', '=', null)->get();

        // $ingredientes = Ingrediente::all();
        $ingredientes = Ingrediente::pluck('nome_ingrediente', 'id');
        // $medidas = MedidasIngrediente::all();
        $medidas = MedidasIngrediente::pluck('nome_medida', 'id');
    	return view('site.receitas.create', compact('categorias', 'ingredientes', 'medidas'));
    }

    public function store() {
    	$this->validate(request(), [
            'nome_receita' => 'required|string|max:255',
            'categoria_id' => 'required|not_in:0',
            'porcao' => 'required',
            'tempo_preparo' => 'required',
            'modo_preparo' => 'required',
            'img_path' => 'required|mimes:jpeg, png',
            // 'nome_ingrediente' => 'required|array|min:3',
            'nome_ingrediente' => 'required|array',
        ]);

        $ingredientes = [];
        foreach(request('nome_ingrediente') as $index=>$ingrediente) {
            $ingrediente_id = $ingrediente;

            if(!is_numeric($ingrediente)) {
                $ingrediente = Ingrediente::where('nome_ingrediente', $ingrediente)->first();
                if($ingrediente != null) {
                    $ingrediente_id = $ingrediente->id;
                } else {
                    $ingrediente_id = Ingrediente::create([
                        'nome_ingrediente' => $ingrediente_id
                    ])->id;
                }
            } else {

            }
            
            $ingredientes[$ingrediente_id] = [
                'subsessao' => request('receita_ingrediente')['subsessao'][$index],
                'qty' => request('receita_ingrediente')['qty'][$index],
                'medida_id' => request('receita_ingrediente')['medida_id'][$index]
            ];
        }

        $receita = Receita::create([
            'nome_receita' => request('nome_receita'),
            'categoria_id' => request('categoria_id'),
            'user_id' => auth()->id(),
            'porcao' => request('porcao'),
            'tempo_preparo' => request('tempo_preparo'),
            'modo_preparo' => request('modo_preparo'),
            // 'img_path' => request('img_path'),
            'slug' => str_slug(request('nome_receita'), '-')
        ]);

        $receita->ingredientes()->attach($ingredientes);

        $imageName = $receita->id . '.' . request()->file('img_path')->getClientOriginalExtension();

        request()->file('img_path')->move(
            base_path() . '/public/images/receitas/', $imageName
        );

        $receita->img_path = 'images/receitas/' . $imageName;
        $receita->save();

        // Get quantity used in first ingredient
        // $receita->ingredientes->first()->pivot->qty
        // App\Models\Receita::with('receitasIngredientes.medida', 'receitasIngredientes.ingrediente')->first();
        // App\Models\Receita::with('receitasIngredientes.medida', 'receitasIngredientes.ingrediente', 'utensilios')->first();

        return redirect('/');
    }

    // public function show(Receita $receita) {
    public function show($receitaId) {
    	// $receita = Receita::with('receitasIngredientes.medida', 'receitasIngredientes.ingrediente', 'utensilios')->find($receita->id);
    	$receita = Receita::with('receitasIngredientes.medida', 'receitasIngredientes.ingrediente', 'utensilios')->find($receitaId);
    	return view('site.receitas.show', compact('receita'));
    }

    public function edit($receitaId) {
    	return view('site.receitas.edit');
    }

    public function update(Receita $receita) {
    	// TODO
    }

    public function delete($receitaId) {
        return view('site.receitas.delete');
    }

    public function destroy(Receita $receita) {
    	// TODO
    }

    public function search(Request $request) {
    	$nome_receita = $request->get('nome');

    	$query = Receita::whereRaw("lower(nome_receita) like lower('%".$nome_receita."%')");

    	$receitas = $query->orderBy('pontuacao_media', 'DESC')->paginate(1);
    	// $receitas = $query->orderBy('pontuacao_media', 'DESC')->get();

    	dd($receitas);
    }
}
