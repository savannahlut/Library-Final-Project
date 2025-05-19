from flask import Flask, render_template, request
import subprocess

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    output = ""

    if request.method == 'POST':
        action = request.form.get('action')

        try:
            if action == 'run':
                result = subprocess.run(["java", "Main"], capture_output=True, text=True, check=True)
                output = result.stdout.strip()

            elif action == 'author':
                result = subprocess.run(["java", "Main", "author"], capture_output=True, text=True, check=True)
                output = result.stdout.strip()

            elif action == 'reset':
                output = "Output cleared. Ready to run analysis again."

            elif action == 'help':
                output = "Click buttons to see your library's top authors, genres, or other library stats!"

        except subprocess.CalledProcessError as e:
            output = f"Java error: {e.stderr}"
        except FileNotFoundError:
            output = "Java not found. Make sure it's installed and added to PATH."

    return render_template('index.html', output=output)

if __name__ == '__main__':
    app.run(debug=True)
