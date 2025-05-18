from flask import Flask, render_template, request
import subprocess

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    output = ""  # Default empty output
    
    if request.method == 'POST':
        try:
            # Run Java when button is clicked
            result = subprocess.run(
                ["java", "Main"], 
                capture_output=True,
                text=True,
                check=True
            )
            output = result.stdout.strip() 
        except subprocess.CalledProcessError as e:
            output = f"Java error: {e.stderr}"
        except FileNotFoundError:
            output = "Java not found. Make sure it is installed and added to PATH."
    
    return render_template('index.html', output=output)

if __name__ == '__main__':
    app.run(debug=True)
