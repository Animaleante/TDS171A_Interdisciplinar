<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class Categoria extends Model
{
    public function children() {
        return $this->hasMany(Categoria::class, 'id_super_categoria', 'id');
    }
}
