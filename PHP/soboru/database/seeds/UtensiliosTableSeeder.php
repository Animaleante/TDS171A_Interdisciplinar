<?php

use Illuminate\Database\Seeder;
use App\Models\Utensilio;

class UtensiliosTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Utensilio::create([
            'nome_utensilio'=>'Fogão'
        ]);
        Utensilio::create([
            'nome_utensilio'=>'Forno'
        ]);
        Utensilio::create([
            'nome_utensilio'=>'Microondas'
        ]);
        Utensilio::create([
            'nome_utensilio'=>'Geladeira'
        ]);
        Utensilio::create([
            'nome_utensilio'=>'Batedeira'
        ]);
    }
}
