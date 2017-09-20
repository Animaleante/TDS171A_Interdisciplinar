<?php

use Illuminate\Database\Seeder;
use App\Models\MedidasIngrediente;

class MedidasIngredientesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        MedidasIngrediente::create([
            'nome_medida'=> 'grama(s)'
        ]);
        MedidasIngrediente::create([
            'nome_medida'=> 'kilograma(s)'
        ]);
        MedidasIngrediente::create([
            'nome_medida'=> 'colher(es) de chá'
        ]);
        MedidasIngrediente::create([
            'nome_medida'=> 'xícara(s)'
        ]);
    }
}
