from django.http import HttpResponse, Http404
from django.shortcuts import render, get_object_or_404
from .models import Question


def index(request):
    latest_questions = Question.objects.order_by("-pub_date")[:5]
    context = {"latest_questions": latest_questions}
    return render(request, "polls/index.html", context)


def detail(request, question_id: int):
    question = get_object_or_404(Question, pk=question_id)
    return render(request, "polls/detail.html", {"question": question})


def results(request, question_id: int):
    return HttpResponse(f"Results of question {question_id}")


def vote(request, question_id: int):
    return HttpResponse(f"Voting on question {question_id}")
