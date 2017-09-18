<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class PontuacaoReceita extends Model
{
    public function user() {
    	return $this->belongsTo(User::class);
    }
    
    public function receita() {
    	return $this->belongsTo(Receita::class);
    }
}
