const API = "http://localhost:8081/projetos";
const listaProjetos = document.getElementById("listaProjetos");



async function listarProjetos(){

    try{
        const response = await fetch(API);
        const projetos = await response.json();

        if(projetos.length === 0){
            listaProjetos.innerHTML = `
                <p class="sem-dados">
                    Nenhum projeto cadastrado
                </p>
            `;
            return;
        }

        listaProjetos.innerHTML = `
            <table>

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Descrição</th>
                        <th>Data Início</th>
                        <th>Data Fim</th>
                    </tr>
                </thead>

                <tbody>
                    ${projetos.map(projeto => `
                        <tr>
                            <td>${projeto.id}</td>
                            <td>${projeto.descricao}</td>
                            <td>${projeto.dataInicio}</td>
                            <td>${projeto.dataFim}</td>
                        </tr>
                    `).join("")}
                </tbody>
            </table>
        `;

    }catch(error){
        console.error(error);
        alert("Erro ao listar projetos");
    }
}


document
    .getElementById("formProjeto")
    .addEventListener("submit", async function(event){

        event.preventDefault();

        const projeto = {
            descricao:
                document.getElementById("descricao").value,
            dataInicio:
                document.getElementById("dataInicio").value,
            dataFim:
                document.getElementById("dataFim").value
        };

        try{

            const response = await fetch(API, {
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify(projeto)
            });

            if(!response.ok){
                throw new Error("Erro ao cadastrar");
            }
            alert("Projeto cadastrado com sucesso");

            document
                .getElementById("formProjeto")
                .reset();

            listarProjetos();

        }catch(error){

            console.error(error);

            alert("Erro ao cadastrar projeto");
        }

    });

listarProjetos();