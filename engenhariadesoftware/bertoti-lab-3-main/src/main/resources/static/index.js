i = 0
function uuidv4() {
    return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
      (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
  }

const btnAdd = document.getElementById('submitBtn')
function Adicionar() {
    const inputID = document.getElementById('inputID');
    const nomeFilme = document.getElementById('nomeFilme');
    let newId = inputID.value;
    if (!newId) {
        newId = uuidv4();
    }

    axios.post('http://localhost:8080/movies', {
        id: newId,
        name: nomeFilme.value
    }) .then(response => {
        window.location.reload();
        console.log("Filme adicionado", response.data)
    }).catch(e => {
            console.error("Erro ao adicionar o filme:", e);
        }
    )
}
btnAdd.addEventListener('click',Adicionar)

const modal = document.getElementById('id01');

function fecharModal() {
    modal.style.display = 'none';
}

// fecha ao clicar fora do card ou ao apertar Esc
let clickIniciadoNoFundo = false;
modal.addEventListener('mousedown', event => {
    clickIniciadoNoFundo = event.target === modal;
});
modal.addEventListener('click', event => {
    if (clickIniciadoNoFundo && event.target === modal) {
        fecharModal();
    }
    clickIniciadoNoFundo = false;
});
document.addEventListener('keydown', event => {
    if (event.key === 'Escape') {
        fecharModal();
    }
});

function atualizarContador() {
    const total = document.querySelectorAll('#movie-list .movie-card').length;
    document.getElementById('movie-count').textContent = total;
    document.getElementById('empty-state').hidden = total > 0;
}

document.addEventListener("DOMContentLoaded", () => {
    const inputID = document.getElementById('inputID');
    inputID.setAttribute('value', uuidv4());

    fetch("http://localhost:8080/movies")
        .then(response => response.json())
        .then(data => {

            const movieList = document.getElementById("movie-list");
            data.forEach(movie => {
                const listItem = document.createElement("li");
                const nameLabel = document.createElement("span");
                const actions = document.createElement("div");
                const badge = document.createElement("span");
                const deleteButton = document.createElement('button')
                const upItem = document.createElement("input")
                const upButton = document.createElement("button");

                upButton.innerHTML = "Editar nome";
                deleteButton.innerHTML = "Excluir";
                nameLabel.textContent = movie.name;

                listItem.setAttribute('class', 'movie-card');
                badge.setAttribute('class', 'movie-card__index');
                badge.textContent = i + 1;
                nameLabel.setAttribute('class', 'movie-card__name');
                actions.setAttribute('class', 'movie-card__actions');
                upItem.setAttribute('class', 'input input--inline');
                upItem.setAttribute('placeholder', 'Novo nome');
                upButton.setAttribute('id', i);
                upButton.setAttribute('class', 'btn btn--sm');
                deleteButton.setAttribute('class', 'btn btn--danger btn--sm');

                actions.appendChild(upItem);
                actions.appendChild(upButton);
                actions.appendChild(deleteButton);
                listItem.appendChild(badge);
                listItem.appendChild(nameLabel);
                listItem.appendChild(actions);
                movieList.appendChild(listItem);

                i++;
                upButton.addEventListener('click',Update)
                deleteButton.addEventListener('click', Excluir)
                function Update(){
                   upItemValor = upItem.value;
                   axios.put("http://localhost:8080/movies/"+movie.id , { id: movie.id, name: upItemValor })
                   .then(response => {
                    console.log("Filme atualizado com sucesso:", response.data)
                        nameLabel.innerText = upItemValor
                        upItem.value = ''
                })
                .catch(error => {
                    console.error("Erro ao atualizar o filme:", error);
                });


                }

                function Excluir(){
                    axios.delete("http://localhost:8080/movies/"+movie.id, { id: movie.id })
                    .then(response =>{
                        console.log('Deletado', response.data)
                        listItem.remove()
                        atualizarContador()
                    })
                    .catch(error => {
                        console.error("Erro ao deletar", error)
                    })
                }

            });

            atualizarContador();
        })
        .catch(() => atualizarContador());
});
