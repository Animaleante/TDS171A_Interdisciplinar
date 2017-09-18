<?php

use Illuminate\Database\Seeder;
use App\Models\Categoria;

class CategoriasTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Categoria::create([
        	'nome_categoria'=>'CARNES',
        	'selecionavel'=>0,
        	'slug'=>'carnes'
        ]);

        Categoria::create([
        	'nome_categoria'=>'Alcatra',
        	'id_super_categoria'=>1,
        	'selecionavel'=>1,
        	'slug'=>'alcatra'
        ]);
        Categoria::create([
        	'nome_categoria'=>'Picanha',
        	'id_super_categoria'=>1,
        	'selecionavel'=>1,
        	'slug'=>'picanha'
        ]);
    }
}
