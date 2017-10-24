<?php

use Illuminate\Database\Seeder;
use App\Models\Role;

class RolesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        /*DB::table('roles')->insert([
            'nome' => 'Usuário'
        ]);
        DB::table('roles')->insert([
            'nome' => 'Admin'
        ]);*/

        Role::create([
        	'nome'=> 'Usuário'
        ]);
        Role::create([
        	'nome'=> 'Admin'
        ]);
    }
}
