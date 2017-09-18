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
            'nome_role' => 'Usuário'
        ]);
        DB::table('roles')->insert([
            'nome_role' => 'Admin'
        ]);*/

        Role::create([
        	'nome_role'=> 'Usuário'
        ]);
        Role::create([
        	'nome_role'=> 'Admin'
        ]);
    }
}
