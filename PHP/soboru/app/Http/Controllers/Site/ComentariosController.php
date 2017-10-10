<?php

namespace App\Http\Controllers\Site;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\Comentario;
use App\Models\Receita;

class ComentariosController extends Controller
{
    public function store(Receita $receita) {
    // public function store($receitaId) {
    	$this->validate(request(), [
    		'body' => 'required|min:3'
    	]);

    	/*$comentario = Comentario::create([
    		'body' => request('body'),
    		'user_id' => Auth::id()
    	]);*/

    	$comentario = new Comentario();
    	$comentario->body = request('body');
    	$comentario->user_id = Auth::id();
    	$comentario->receita_id = $receita->id;
    	// $comentario->receita_id = receitaId;
    	$comentario->save();

    	return back();
    }
}
