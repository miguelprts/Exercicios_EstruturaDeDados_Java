import subprocess

test_cases = [
    (48, 18),
    (56, 98),
    (101, 103),
    (270, 192),
    (44, 0)
]

def run_java_program(n1, n2):
    process = subprocess.Popen(
        ['java', 'Ex_3'], 
        stdin=subprocess.PIPE, 
        stdout=subprocess.PIPE, 
        stderr=subprocess.PIPE, 
        text=True
    )

    stdout, stderr = process.communicate(f"{n1}\n{n2}\n")

    if process.returncode == 0:
        print(f"Entrada: ({n1}, {n2}) -> Saída: {stdout.strip()}")
    else:
        print(f"Erro ao executar com entrada ({n1}, {n2}): {stderr}")

for n1, n2 in test_cases:
    run_java_program(n1, n2)
