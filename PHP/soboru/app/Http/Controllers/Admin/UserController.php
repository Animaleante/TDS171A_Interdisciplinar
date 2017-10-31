<?php

namespace App\Http\Controllers\Admin;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\RegistersUsers;
use App\Models\User;
use App\Models\Role;

class UserController extends Controller
{
    use RegistersUsers;

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $results = User::all();
        return view('admin.user.index', compact('results'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $roles = Role::all();
        return view('admin.user.create', compact('roles'));
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate(request(), [
            'nome' => 'required|string|max:255',
            'login' => 'required|string|max:255|unique:users,deleted_at,NULL',
            'email' => 'required|string|email|max:255|unique:users,deleted_at,NULL',
            'password' => 'required|string|min:6|confirmed',
            'nasc' => 'required',
            'role_id' => 'required',
            'sexo_id' => 'required'
        ]);

        User::create([
            'nome' => $request['nome'],
            'login' => $request['login'],
            'email' => $request['email'],
            'password' => bcrypt($request['password']),
            'role_id' => $request['role_id'],
            'nasc' => implode('-', array_reverse(explode('/', $request['nasc']))),
            'sexo_id' => $request['sexo_id'],
            'notificacao_email' => isset($request['notificacao_email']) ? 1 : 0,
        ]);

        return redirect()->route('admin.user.index')->with('success', true);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  User  $user
     * @return \Illuminate\Http\Response
     */
    public function edit(User $user)
    {
        // $user = User::find($id);
        $roles = Role::all();

        return view('admin.user.edit', compact('user', 'roles'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $user = User::find($id);

        if($user) {
            $user->delete();
        }

        return redirect()->route('admin.user.index')->with('success', true);
    }
}
